package DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.AirTrafficControllersImpl;

import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.AirCraftsImpl.BaseAircraft;
import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.AirTrafficControllers.AirTrafficController;
import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.Exceptions.RunwayAllocationException;
import DesignPattern.BehavioralPatterns.MediatorAirTrafficControl.Runways.Runway;

public class MumbaiAirTrafficController implements AirTrafficController {

    private final static Logger LOGGER = Logger.getLogger(MumbaiAirTrafficController.class.getName());

    // AirCraft id vs Runway.
    private ConcurrentHashMap<String, Runway> allocatedRunways;
    private ConcurrentHashMap<String, BaseAircraft> aircrafts;
    private Queue<Runway> availableRunways;
    ReentrantLock lock;

    public MumbaiAirTrafficController(List<Runway> runways) {
        availableRunways = new ConcurrentLinkedQueue<>(runways);
        allocatedRunways = new ConcurrentHashMap<>();
        lock = new ReentrantLock(true);
        aircrafts = new ConcurrentHashMap<>();
    }

    @Override
    public void registerAirCraft(BaseAircraft airCraft) {
        aircrafts.put(airCraft.getAirCraftId(), airCraft);
    }

    @Override
    public void deRegisterAirCraft(BaseAircraft airCraft) {
        aircrafts.compute(airCraft.getAirCraftId(), (key, value) -> null);
    }

    @Override
    public int requestLanding(BaseAircraft airCraft) throws RunwayAllocationException, InterruptedException {
        if (lock.tryLock() || lock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                Runway runway = availableRunways.poll();
                if (runway != null) {
                    runway.changeOccupancy();
                    allocatedRunways.put(airCraft.getAirCraftId(), runway);
                    return runway.getRunwayId();
                }
            } catch (Exception e) {
                throw new RunwayAllocationException(
                        "Mumbai Traffic Controller, Technical issue while allocating runway for landing aircraft "
                                + airCraft.getAirCraftId());
            } finally {
                lock.unlock();
            }
        } else {
            LOGGER.info("Aircraft " + airCraft.getAirCraftId() + " failed to acquire runway for landing.");
        }

        return -1;
    }

    @Override
    public void landingNotification(BaseAircraft airCraft) throws RunwayAllocationException, InterruptedException {

        if (lock.tryLock() || lock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                Optional<Runway> freeRunway = Optional.ofNullable(allocatedRunways.remove(airCraft.getAirCraftId()));
                freeRunway.ifPresent((runway) -> {
                   runway.changeOccupancy();
                   availableRunways.add(runway); 
                });
            } catch (Exception e) {
                throw new RunwayAllocationException(
                        "Mumbai Traffic Controller, Technical issue while deallocating runway for aircraft "
                                + airCraft.getAirCraftId());
            } finally {
                lock.unlock();
            }
        } else {
             LOGGER.info("Aircraft " + airCraft.getAirCraftId() + " failed to release runway after landing.");
        }
    }

}

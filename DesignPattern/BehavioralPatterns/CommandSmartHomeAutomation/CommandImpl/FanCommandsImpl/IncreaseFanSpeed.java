package DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.CommandImpl.FanCommandsImpl;


import DesignPattern.BehavioralPatterns.CommandSmartHomeAutomation.Devices.Fan;

public class IncreaseFanSpeed extends FanCommand {


  public IncreaseFanSpeed(String id) {
    super(id);
  }

  @Override
  public void execute() {
    getFan().ifPresentOrElse((Fan fan) -> fan.increaseSpeed(), () -> System.out.println("Fan not found"));
  }

  @Override
  public void undo() {
    getFan().ifPresentOrElse((Fan fan) -> fan.decreaseSpeed(), () -> System.out.println("Fan not found"));
  }
}

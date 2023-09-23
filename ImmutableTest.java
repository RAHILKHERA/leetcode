public class ImmutableTest {
    

}


final class Immutable {

    private final int member1;
    
    private final int member2;
    
    Immutable(int member1, int member2) {
        this.member1 = member1;
        this.member2 = member2;
    }

    public int getMember1() {
        return member1;
    }

    public int getMember2() {
        return member2;
    }

}

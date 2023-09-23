public class CloneDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        
      B b0 = new B();
      b0.b = 5;
      b0.aa.a = 6;

      B b1 = (B) b0.clone();
      b1.b = 7;
      b1.aa.a = 8;

    //   System.out.println(b0);
    //   System.out.println(b1);

      C c0 = new C();
      c0.aa.a = 321;
      c0.b = 12;
      c0.c = 2;

      

      C c1 =  (C) c0.clone();
      c1.c = 3;
      c1.b= 21;
      c1.aa.a = 123;

      System.out.println(c0);
      System.out.println(c1);

    }
}

class C extends B {

    int c;
    @Override
    public String toString() {
        
        return  "C { c = " + c + "}"  + super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        C c = (C) super.clone();
        c.aa = (A) this.aa.clone();
        return c;
    }

}

class B implements Cloneable{

    int b;
    A aa;

    B() {
        b = 0;
        aa = new A();
        aa.a = 1;
    }

    @Override
    public String toString() {
        
        return "B { b = " + b + ", aa = "  + aa + "}" ;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class A implements Cloneable{

    int a;

    
    @Override
    public String toString() {
        
        return "A { a = " + a + "}" ;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
interface SomeInterface{
    public void doSomething();
}

interface SomeOtherInterface {
    public void doSomeOther();
}

class SomeImpl implements SomeInterface {
    public void doSomething() { System.out.println("A"); }
}

class OtherImpl implements SomeInterface {
    public void doSomething(){ System.out.println("B"); }
}

class SODoer implements SomeOtherInterface {
    public void doSomeOther(){ System.out.println("C"); }
}
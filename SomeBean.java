class SomeBean {
    @AutoInjectable
    private SomeInterface field1;
    @AutoInjectable
    private SomeOtherInterface field2;

    public SomeBean() {
    }

    public void foo(){
        field1.doSomething();
        field2.doSomeOther();
    }
}
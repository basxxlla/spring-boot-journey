// Multiple interfaces
interface MultipleInterfaceA { void methodA(); }
interface MultipleInterfaceB { void methodB(); }

class MultiClass implements MultipleInterfaceA, MultipleInterfaceB {
    public void methodA() {}
    public void methodB() {}
}



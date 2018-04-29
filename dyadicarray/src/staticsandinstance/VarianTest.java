package staticsandinstance;

public class VarianTest {

    public static int staticVar =0;

    public int instanceVar=0;

    public VarianTest() {
        staticVar++;
        instanceVar++;
        System.out.println("staticVar="+staticVar+",instanceVar="+instanceVar);
    }
}

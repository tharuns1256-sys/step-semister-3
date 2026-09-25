abstract class GardenTool {

    public abstract String use();
}

class CuttingTool extends GardenTool {

    public CuttingTool() {
        super();
    }

    public String use() {

        return superUse();
    }

    private String superUse() {

        return "Using the tool in the garden, blade sharpened first";
    }
}

class Pruner extends CuttingTool {

    public Pruner() {
        super();
    }

    public String use() {

        return super.use() +
               ", then trimming branches precisely";
    }
}

public class GardenDemo {

    public static void main(String[] args) {

        CuttingTool c = new CuttingTool();
        Pruner p = new Pruner();

        System.out.println(c.use());
        System.out.println(p.use());
    }
}
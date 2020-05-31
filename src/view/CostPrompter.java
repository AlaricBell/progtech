package view;

public class CostPrompter extends Prompt {
    private String costChangeOption = "Enter new price. (format: 2.50)\n";

    public String getCostChangeOptions() {
        return this.costChangeOption;
    }
}

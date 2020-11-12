package tabs;

import javafx.scene.control.Tab;

public class CompanyList extends Tab {
    private static CompanyList tab;

    private CompanyList() {
        super("Movie Companies List");
    }

    public static CompanyList getInstance(){
        if(tab == null){
            tab = new CompanyList();
        }

        return tab;
    }
}

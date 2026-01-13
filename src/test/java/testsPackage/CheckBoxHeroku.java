package testsPackage;

import ListenerPackage.ListenerPage;
import baseSetPackage.BaseHerokuSet;
import org.testng.ITestNGListener;
import org.testng.annotations.*;
import ScriptPages.HerokuAppPage;
import java.io.IOException;

    @Listeners(ListenerPage.class)
    public class CheckBoxHeroku extends BaseHerokuSet implements ITestNGListener {

        HerokuAppPage herokuappkey;
        @BeforeClass
        public void setcheck() throws InterruptedException, IOException {
            herokuappkey = new HerokuAppPage(driver);
        }
        @Test(priority = 1)
        public void checkboxer() throws Exception {
            herokuappkey.herokuWeb();
            herokuappkey.CheckUncheckBox();
        }
        @Test(priority = 2)
        public void addelement() throws Exception {
            herokuappkey.herokuWeb();
            herokuappkey.AddRemoveElement();
        }
        @Test(priority = 3)
        public void basicauthor() throws Exception {
            herokuappkey.herokuWeb();
            herokuappkey.BasicAuth();
        }
        @Test(priority = 4)
        public void elemDisappear() throws Exception {
            herokuappkey.herokuWeb();
            herokuappkey.DisappearElement();
        }
        @Test(priority = 5)
        public void authForm() throws Exception {
            herokuappkey.herokuWeb();
            herokuappkey.FormAuthenticate();
        }
        @Test(priority = 6)
        public void ipForm() throws Exception {
            herokuappkey.herokuWeb();
            herokuappkey.Inputs();
        }
        @Test(priority = 7)
        public void pgScroll() throws Exception {
            herokuappkey.herokuWeb();
            herokuappkey.ePageScroll();
        }
        @Test(priority = 8)
        public void dragop() throws Exception {
            herokuappkey.herokuWeb();
            herokuappkey.dragsndrops();
        }
        @Test(priority = 9)
        public void dropdoun() throws Exception {
            herokuappkey.herokuWeb();
            herokuappkey.dropdownopt();
        }
    }

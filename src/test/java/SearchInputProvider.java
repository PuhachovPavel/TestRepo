import org.testng.annotations.DataProvider;

public class SearchInputProvider {

    @DataProvider
    public static Object[][] searchInputProvider () {
        Object[][] data = new Object[3][1];
        data [0][0] = "Чайник Krauff";
        data [1][0] = "redmi note 9";
        data [2][0] = "Велосипед Pride";
        return data;
    }

}

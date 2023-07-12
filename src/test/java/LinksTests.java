import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import utils.BaseTest;

@Slf4j
public class LinksTests extends BaseTest {

    @Test(description = "Test to see if kitchen accessories are sorted properly")
    public void sortingKitchenAccessories() {
        openHomePage()
                .validateHomePageLoadingCompleted(30)
                .checkAndClosCookiesPopUp()
                .openSmallHouseholdAppliancesPage()
                .validateSmallHouseholdAppliancesPageLoadingCompleted(30)
                .pickKitchenAccessoriesCategory()
                .validateKitchenAccessoriesPageLoadingCompleted(30)
                .sortFromLowerToHigherPrice()
                .checkIfItemsAreSortedProperly()
                .pickANumberOfItemsShownOnPage();
    }

    @Test(description = "Test of buying the most expensive road gps navigation", dependsOnMethods = "sortingKitchenAccessories")
    public void buyTheMostExpensiveRoadGPSNavigation() {
        openHomePage()
                .validateHomePageLoadingCompleted(30)
                .checkAndClosCookiesPopUp()
                .openTvOrAudioVideoPage()
                .validateTvOrAudioVideoPageLoadingCompleted(30)
                .pickGPSNavigationCategory()
                .validateGPSNavigationPageLoadingCompleted(30)
                .pickRoadNavigationCategory()
                .sortRoadGPSNavigationsFromHigherToLowerPrice()
                .addTheMostExpensiveItemToTheCart()
                .checkIfNotificationBarIsVisibleAndContainsRightMessage("Proizvod je dodan")
                .checkQuantityInCart()
                .openCartPage()
                .validateCartPageLoadingCompleted(30)
                .submitOrder();
    }

    @Test(description = "Test of comparing two products", dependsOnMethods = "buyTheMostExpensiveRoadGPSNavigation")
    public void compareProducts() {
        openHomePage()
                .validateHomePageLoadingCompleted(30)
                .checkAndClosCookiesPopUp()
                .openSalesPage()
                .validateSalesPageLoadingCompleted(30)
                .clickToCheckBoxOnSalesPage("monitor", 7)
                .checkIfOnlySelectedItemsAreDisplayed("monitor")
                .addSecondItemToCompareList("monitor")
                .checkIfNotificationBarIsVisibleWithMessage("dodan u vašu listu usporedi")
                .clickToUncheckBoxOnSalesPage("monitor")
                .clickToCheckBoxOnSalesPage("tableti lenovo", 4)
                .checkIfOnlySelectedItemsAreDisplayed("tablet lenovo")
                .addSecondItemToCompareList("tablet lenovo")
                .checkIfNotificationBarIsVisibleWithMessage("dodan u vašu listu usporedi")
                .openComparePage()
                .validateComparePageLoadingCompleted(30)
                .checkNumberOfProductsAndDeleteAll();
    }
}
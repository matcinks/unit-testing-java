package pl.mat.testing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void shouldReturnDiscountedPrice() {

        // given
        Meal newMeal = new Meal(35);

        // when
        int discountedPrice = newMeal.getDiscountedPrice(7);

        // then
        assertEquals(28, discountedPrice);
        assertThat(discountedPrice).isEqualTo(28);
    }

    @Test
    void referencesToTheSameObjectShouldBeEqual() {

        // givven
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;

        // then
        assertSame(meal1, meal2);
        assertThat(meal1).isSameAs(meal2);

    }

    @Test
    void referencesToTheDifferentObjectShouldBeEqual() {

        // givven
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(20);

        // then
        assertNotSame(meal1, meal2);
        assertThat(meal1).isNotSameAs(meal2);

    }

    @Test
    void twoMealsShouldBeEqualWhenPriceAndNameAreTheSame() {

        // given
        Meal meal1 = new Meal(10, "Pizza");
        Meal meal2 = new Meal(10, "Pizza");

        // then
        assertEquals(meal1, meal2, "Checking if two meals are equal");
        assertThat(meal1).isEqualTo(meal2);
    }


}
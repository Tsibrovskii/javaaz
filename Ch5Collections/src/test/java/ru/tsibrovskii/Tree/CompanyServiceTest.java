package ru.tsibrovskii.Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тестовый класс.
 */
public class CompanyServiceTest {

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGetTopLevelCompanyShouldReturnRootCompany() {

        Company first = new Company(null, 3);
        Company second = new Company(first, 1);
        Company third = new Company(second, 0);

        CompanyService companyService = new CompanyService();

        Company result = companyService.getTopLevelParent(third);
        assertThat(result, is(first));
    }

    /**
     * Тестовый метод.
     */
    @Test
    public void whenGetAllEmployeesShouldReturnCount() {

        Company first = new Company(null, 3);
        Company second = new Company(first, 1);
        Company third = new Company(second, 0);

        List<Company> companyList = new ArrayList<>();

        companyList.add(second);
        companyList.add(third);

        CompanyService companyService = new CompanyService();

        long result = companyService.getEmployeeCountForCompanyAndChildren(first, companyList);
        assertThat(result, is((long)4));
    }
}

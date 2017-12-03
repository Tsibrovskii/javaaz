package ru.tsibrovskii.Tree;

import java.util.List;

/**
 * Класс поиска.
 */
public class CompanyService implements ICompanyService {

    /**
     * @param child - company for whom we are searching the top
     * level parent (parent of parent of...)
     * @return top level parent
     */
    public Company getTopLevelParent(Company child) {
        Company headCompany = child;
        if(child.parent != null) {
            headCompany = getTopLevelParent(child.parent);
        }
        return headCompany;
    }

    /**
     * @param company - company for whom we are searching count of employees
     * (count of this company employees +
     * count of employees for all children companies and their children, etc.)
     * @param companies - all available companies
     * @return count of employees
     */
    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        long count = 0;
        if(!companies.contains(company)) {
            count = company.employeeCount;
        }
        for (Company comp : companies) {
            if(company == getTopLevelParent(comp)) {
                count += comp.employeeCount;
            }
        }
        return count;
    }
}

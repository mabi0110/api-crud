package pl.javastart.apicrud.company;

import org.springframework.stereotype.Service;

@Service
public class CompanyDtoMapper {

    CompanyDto map(Company company) {
        CompanyDto companyDto  = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setDescription(company.getDescription());
        companyDto.setCity(company.getCity());
        companyDto.setEmployees(company.getEmployees());
        companyDto.setTelephone(company.getTelephone());
        companyDto.setEmail(company.getEmail());
        return companyDto;
    }

    Company map(CompanyDto companyDto) {
        Company company = new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setDescription(companyDto.getDescription());
        company.setCity(companyDto.getCity());
        company.setEmployees(companyDto.getEmployees());
        company.setTelephone(companyDto.getTelephone());
        company.setEmail(companyDto.getEmail());
        return company;
    }
}

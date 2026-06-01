package pl.javastart.apicrud.company;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyDtoMapper companyDtoMapper;
    private final CompanyJobOfferDtoMapper companyJobOfferDtoMapper;

    public CompanyService(CompanyRepository companyRepository, CompanyDtoMapper companyDtoMapper, CompanyJobOfferDtoMapper companyJobOfferDtoMapper) {
        this.companyRepository = companyRepository;
        this.companyDtoMapper = companyDtoMapper;
        this.companyJobOfferDtoMapper = companyJobOfferDtoMapper;
    }

    Optional<CompanyDto> getCompanyById(Long id) {
        return companyRepository.findById(id).map(companyDtoMapper::map);
    }

    List<CompanyJobOfferDto> getJobOffersByCompanyId(Long id) {
        return companyRepository.findById(id)
                .map(Company::getJobOfferList)
                .orElse(Collections.emptyList())
                .stream()
                .map(companyJobOfferDtoMapper::map)
                .toList();
    }

    CompanyDto saveCompany(CompanyDto companyDto) {
        Company companyToSave = companyDtoMapper.map(companyDto);
        Company savedCompany = companyRepository.save(companyToSave);
        return companyDtoMapper.map(savedCompany);
    }
    
    Optional<CompanyDto> replaceCompany(Long id, CompanyDto companyDto) {
        if (!companyRepository.existsById(id)) {
            return Optional.empty();
        }
        companyDto.setId(id);
        Company companyToUpdate = companyDtoMapper.map(companyDto);
        Company updatedCompany = companyRepository.save(companyToUpdate);
        return Optional.of(companyDtoMapper.map(updatedCompany));
    }

}

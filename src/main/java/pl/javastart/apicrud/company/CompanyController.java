package pl.javastart.apicrud.company;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{id}")
    ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/offers")
    ResponseEntity<List<CompanyJobOfferDto>> getOffersByCompanyId(@PathVariable Long id) {
        if (companyService.getCompanyById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(companyService.getJobOffersByCompanyId(id));
    }

    @PostMapping
    ResponseEntity<CompanyDto> saveCompany(@RequestBody CompanyDto companyDto) {
        CompanyDto savedCompany = companyService.saveCompany(companyDto);
        URI companyUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCompany.getId())
                .toUri();
        return ResponseEntity.created(companyUri).body(savedCompany);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> replaceCompany(@PathVariable Long id, @RequestBody CompanyDto companyDto) {
        Optional<CompanyDto> optionalCompanyDto = companyService.replaceCompany(id, companyDto);
        if (optionalCompanyDto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

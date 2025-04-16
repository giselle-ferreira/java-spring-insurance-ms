package br.com.acme.insurance_quote_ms.interfaces.controller;

import br.com.acme.insurance_quote_ms.application.service.QuoteService;
import br.com.acme.insurance_quote_ms.interfaces.dto.CreateQuoteRequestDTO;
import br.com.acme.insurance_quote_ms.interfaces.dto.CreateQuoteRequestDTO;
import br.com.acme.insurance_quote_ms.interfaces.dto.QuoteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quotes")
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteService quoteService;

    @PostMapping
    public ResponseEntity<QuoteResponseDTO> createQuote(@RequestBody CreateQuoteRequestDTO request) {
        QuoteResponseDTO response = quoteService.createQuote(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuoteResponseDTO> consultQuoteById(@RequestParam Long id) {
        QuoteResponseDTO response = quoteService.consultQuoteById(id);
        return ResponseEntity.ok(response);
    }
}

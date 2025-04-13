package br.com.acme.insurance_quote_ms.interfaces.controller;

import br.com.acme.insurance_quote_ms.application.service.QuoteService;
import br.com.acme.insurance_quote_ms.interfaces.dto.CreateQuoteRequest;
import br.com.acme.insurance_quote_ms.interfaces.dto.QuoteResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping
    public ResponseEntity<QuoteResponseDTO> createQuote(@RequestBody CreateQuoteRequest request) {
        QuoteResponseDTO response = quoteService.createQuote(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuoteResponseDTO> consultQuoteById(@RequestParam Long id) {
        QuoteResponseDTO response = quoteService.consultQuoteById(id);
        return ResponseEntity.ok(response);
    }
}

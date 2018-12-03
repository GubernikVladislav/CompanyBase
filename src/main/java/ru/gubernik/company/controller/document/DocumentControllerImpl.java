package ru.gubernik.company.controller.document;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gubernik.company.view.document.DocumentView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * {@inheritDoc}
 */
@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class DocumentControllerImpl implements DocumentController {

    /**
     *{@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/docs", method = {POST})
    public List<DocumentView> docs() {
        return null;
    }
}

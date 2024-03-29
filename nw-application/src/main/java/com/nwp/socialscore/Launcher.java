package com.nwp.socialscore;

import com.nwp.socialscore.repl.application.service.SocialScoreOperationService;
import com.nwp.socialscore.repl.application.service.SocialScoreReaderService;
import com.nwp.socialscore.repl.infrastructure.service.SocialScoreUrlValidator;

public class Launcher {

    // Note: We could use text blocks here if >= JDK v15.
    private static final String STARTUP_MESSAGE =
                    "+--------------------------------------------------------------------------+\n" +
                    "| -------            URL Storage System Started                    ------- |\n" +
                    "| Commands Available: ADD, REMOVE, EXPORT                                  |\n" +
                    "| Description: Domain's can be stored and can be compared with other URLs  |\n" +
                    "|              from their score metric.                                    |\n" +
                    "|              Try add, remove and export some valid URLs to see           |\n" +
                    "|              how it works!                                               |\n" +
                    "+--------------------------------------------------------------------------+\n";

    public static void main(String[] args) {
        System.out.println(STARTUP_MESSAGE);
        SocialScoreUrlValidator socialScoreUrlValidator = new SocialScoreUrlValidator();
        SocialScoreOperationService socialScoreOperationService = new SocialScoreOperationService(socialScoreUrlValidator);
        SocialScoreReaderService socialScoreReaderService = new SocialScoreReaderService(socialScoreUrlValidator, socialScoreOperationService);
        socialScoreReaderService.startRepl();
    }
}

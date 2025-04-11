package project.syed.SpringAI.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIDrivenRestController {

    private final ChatClient chatClient;

    public AIDrivenRestController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping("getMeAnAnswer")
    public ResponseEntity<String> hitAIEngineForAnAnswer(@RequestParam("question") String question) {
        try {
            String response = chatClient.prompt(question).call().content();
            System.out.println("Got a response from AI Engine: "+response);
            return ResponseEntity.ok(response);
        }
        catch(Exception e){
            System.out.println("Exception! It is sucks, but you got one here: "+e);
            return ResponseEntity.internalServerError().body("Roadblock, hold back tight service would be back soon -:)");
        }
    }
}

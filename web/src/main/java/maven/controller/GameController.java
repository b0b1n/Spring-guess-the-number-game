package maven.controller;

import lombok.extern.slf4j.Slf4j;
import maven.service.GameService;
import maven.util.AttributeNames;
import maven.util.GameMappings;
import maven.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.Attribute;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class GameController {
    // == fields ==
    private final GameService gameService;

    // == constructor ==
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @ResponseBody
    @GetMapping("test1")
    public String test1(HttpServletResponse res) {
        Cookie cookie = new Cookie("name", "value");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        res.addCookie(cookie);
        return "salah tezzzt";
    }

    @ResponseBody
    @GetMapping("test2")
    public String test2(HttpServletResponse res) {
        String str = "let decodedCookie = decodeURIComponent(document.cookie);"
                + "  let ca = decodedCookie.split(';');"
                + "console.table(ca);";
        res.setHeader("Content-Type", "text/html");
        return "<script>" + str + "</script>";
    }

    @GetMapping(GameMappings.PLAY)
    public String play(Model model) {
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        log.info("model = {}", model);
        return gameService.isGameOver() ? ViewNames.GAME_OVER : ViewNames.PLAY;
    }

    @PostMapping(GameMappings.PLAY)
    public String processMessage(@RequestParam int guess) {
        log.info("guess = {}", guess);
        gameService.checkGuess(guess);
        return GameMappings.REDIRECT_PLAY;
    }

    @GetMapping(GameMappings.RESTART)
    public String restart() {
        gameService.reset();
        return GameMappings.REDIRECT_PLAY;
    }
}


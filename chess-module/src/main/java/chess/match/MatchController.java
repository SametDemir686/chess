package chess.match;

import chess.piece.PieceDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchController {

    private Match match = new Match();

    @CrossOrigin
    @GetMapping("/getBoard")
    public PieceDTO[][] getBoard(Perspective perspective) {
        return match.getBoard(perspective);
    }

    @CrossOrigin
    @GetMapping("/getBoardAsString")
    public String getBoardAsString(Perspective perspective) {
        return match.getBoardAsString(perspective);
    }

    @CrossOrigin
    @PostMapping("/move")
    public boolean move(A1Notation from, A1Notation to) {
        return match.move(from, to);
    }

    @CrossOrigin
    @PostMapping("/restart")
    public void restart() {
        match.restart();
    }

}

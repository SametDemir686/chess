package chess.match;

import chess.notations.Perspective;
import chess.notations.Position;
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
    @PostMapping("/move")
    public boolean move(Position from, Position to) {
        return match.move(from, to);
    }

    @CrossOrigin
    @PostMapping("/restart")
    public void restart() {
        match.restart();
    }

}

package com.Team4.SmartTowns.qrpage;

import com.Team4.SmartTowns.checkpoints.service.CheckpointService;
import com.Team4.SmartTowns.medals.service.MedalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class QRController {

    private final CheckpointService checkpointService;
    private final MedalService medalService;

    @Autowired
    public QRController(CheckpointService checkpointService, MedalService medalService) {
        this.checkpointService = checkpointService;
        this.medalService = medalService;
    }

    @GetMapping("/scan")
    public String qrScannerPage() {
        return "QRpage/scan-qr";
    }

    @PostMapping("/scan")
    public ResponseEntity<?> handleQRCodeScan(@RequestBody String checkpointId, Principal principal) {
        String username = principal.getName();
        Long id = Long.parseLong(checkpointId.trim());

        checkpointService.addCheckpointToUser(id, username);
        medalService.awardMedalToUser(username);

        return ResponseEntity.ok("Checkpoint added successfully");
    }
}

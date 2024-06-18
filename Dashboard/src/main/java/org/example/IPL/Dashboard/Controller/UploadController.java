package org.example.IPL.Dashboard.Controller;

import org.example.IPL.Dashboard.Model.Match;
import org.example.IPL.Dashboard.Service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/upload")
public class UploadController {
    @Autowired
    private MatchService matchService;

    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        List<Match> matches = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    Match match = new Match();
                    match.setTeam1(data[0]);
                    match.setTeam2(data[1]);
                    match.setDate(LocalDate.parse(data[2]));
                    match.setVenue(data[3]);
                    match.setWinner(data[4]);
                    matches.add(match);
                }
            }
            matchService.saveAll(matches);
            return "File uploaded successfully";
        } catch (Exception e) {
            return "Error uploading file: " + e.getMessage();
        }
    }
}


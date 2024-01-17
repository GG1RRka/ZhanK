package com.example.demo.controller;

import com.example.demo.domain.Team;
import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/team")
public class TeamController {


    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/getTeams")
    public ResponseEntity<List<Team>> getTeams() {
        return ResponseEntity.ok().body(teamService.getTeams());
    }

    @PostMapping("/insertTeam")
    public ResponseEntity<String> insertTeam(@RequestBody Team team) {
        teamService.insert(team);
        return ResponseEntity.ok().body("Successfully inserted team with id " + team.id + ".\n");
    }

    @DeleteMapping("/deleteTeam/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable("id") Long id) {
        String params = "";
        if (teamService.findTeamById(id) != null) params = teamService.findTeamById(id).print();
        teamService.delete(id);
        if (params.isEmpty()) return new ResponseEntity<>("Cannot delete team with id " + id + ": This team doesn't exist.\n", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok().body("Successfully deleted team with id " + id + ".\n");
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<String> getTeamById(@PathVariable("id") Long id) {
        if (teamService.findTeamById(id) == null) return new ResponseEntity<>("Cannot find team with id " + id + ": This team doesn't exist\n", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok().body("Successfully found team with id " + id + ".\n");
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<String> getTeamsByName(@PathVariable("name") String name) {
        if (teamService.findTeamsByName(name) == null) return new ResponseEntity<>("Cannot find team with name " + name + ": This team doesn't exist\n", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok().body("Successfully found team(s) with name " + name + ".\n");
    }

    @GetMapping("/getByCountry/{country}")
    public ResponseEntity<String> getTeamsByCountry(@PathVariable("country") String country) {
        if (teamService.findTeamsByCountry(country) == null) return new ResponseEntity<>("Cannot find team with country " + country + ": This team doesn't exist\n", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok().body("Successfully found team(s) with country " + country + ".\n");
    }

    @GetMapping("/getByEarnings/{earnings}")
    public ResponseEntity<String> getTeamsByEarnings(@PathVariable("earnings") Long earnings) {
        if (teamService.findTeamsByEarnings(earnings) == null) return new ResponseEntity<>("Cannot find team with earnings " + earnings + ": This team doesn't exist\n", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok().body("Successfully found team(s) with earnings " + earnings + ".\n");
    }

    @GetMapping("/getByCurrency/{currency}")
    public ResponseEntity<String> getTeamsByEarnings(@PathVariable("currency") String currency) {
        if (teamService.findTeamsByCurrency(currency) == null) return new ResponseEntity<>("Cannot find team with currency " + currency + ": This team doesn't exist\n", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok().body("Successfully found team(s) with currency " + currency + ".\n");
    }
}
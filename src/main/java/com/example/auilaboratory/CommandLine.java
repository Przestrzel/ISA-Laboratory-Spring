package com.example.auilaboratory;

import com.example.auilaboratory.team.entity.Player;
import com.example.auilaboratory.team.entity.Team;
import com.example.auilaboratory.team.service.PlayerService;
import com.example.auilaboratory.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Scanner;

@Component
public class CommandLine implements CommandLineRunner {

    private TeamService teamService;

    private PlayerService playerService;

    @Autowired
    public CommandLine(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean doExit = false;
        while(!doExit){
            System.out.println("List of available commands:");
            System.out.println("Teams | Players | Add (player) | Delete (player) | Exit");
            switch(scanner.nextLine()){
                case "Teams":
                    teamService.findAll().forEach(System.out::println);
                    break;
                case "Players":
                    playerService.findAll().forEach(System.out::println);
                    break;
                case "Add":
                    Player addedPlayer = addPlayerForm();
                    playerService.save(addedPlayer);
                    break;
                case "Delete":
                    deletePlayerForm();
                    break;
                case "Exit":
                    System.out.println("Stopping application...");
                    doExit = true;
                    break;
                default:
                    System.out.println("You provided wrong command. Try again.");
                    break;
            }
        }
    }
    private Player addPlayerForm(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("To add new player fulfill following form:");

        System.out.println("Full name: ");
        String name = scanner.nextLine();

        System.out.println("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Height[meters]: ");
        double height = Double.parseDouble(scanner.nextLine());

        System.out.println("Weight[kg]: ");
        double weight = Double.parseDouble(scanner.nextLine());

        System.out.println("Position: ");
        String position = scanner.nextLine();

        System.out.println("Value[$]: ");
        int value = Integer.parseInt(scanner.nextLine());

        System.out.println("Nationality: ");
        String nationality = scanner.nextLine();

        boolean isTeamCorrect = false;
        Player player = new Player(name, age, height, weight, position, value, nationality, null);
        do {
            teamService.findAll().forEach(System.out::println);
            System.out.println("Pick a team [name]: ");
            System.out.println("If you want to exit, type 'exit'");

            String teamName = scanner.nextLine();
            Optional<Team> pickedTeam = teamService.find(teamName);

            if(pickedTeam.isPresent()) {
                player.setTeam(pickedTeam.get());
                isTeamCorrect = true;
            } else if (teamName == "exit"){
                isTeamCorrect = true;
            }
            else {
                System.out.println("The provided team name is incorrect. Try again");
            }
        } while(!isTeamCorrect);

        return player;
    }

    private void deletePlayerForm(){
        boolean isPlayerCorrect = false;
        do {
            System.out.println("Which player do you want to delete? [Full name]");
            System.out.println("If you want to exit, type 'exit'");
            playerService.findAll().forEach(System.out::println);
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            Optional<Player> toDeletePlayer = playerService.find(name);

            if(toDeletePlayer.isPresent()){
                playerService.delete(toDeletePlayer.get());
                System.out.println("Player " + name + " have been deleted.");
                isPlayerCorrect = true;
            } else if (name == "exit") {
                isPlayerCorrect = true;
            } else {
                System.out.println("There is no such player. Try again");
            }
        } while(!isPlayerCorrect);
    }
}

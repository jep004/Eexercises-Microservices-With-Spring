package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import demo.domain.Player;
import demo.domain.Team;
import demo.repository.TeamRepository;

@SpringBootApplication
public class Application {
	
	@Autowired
	TeamRepository teamRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void init() {
	  	List<Team> list = new ArrayList<>();

	  	Set<Player> set = new HashSet<>();
	  	set.add(new Player("Ter Stegen"," Porter"));
	  	set.add(new Player("Gerard Pique","Defensa"));
	  	set.add(new Player("De Jong","Mig Centre"));
	  	set.add(new Player("Messi","Delanter"));
	  	
	  	list.add(new Team("Barcelona","FC Barcelona",set));
	  	list.add(new Team("Liverpool","Liverpool FC",null));
	  	
	  	teamRepository.saveAll(list);
	  }
}

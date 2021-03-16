package com.babyapps.roomdbmodels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.babyapps.roomdbmodels.entity.*
import com.babyapps.roomdbmodels.entity.relations.PlayerChampionShipCrossRef
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = TeamDatabase.getInstance(this).teamDao()

        val coachs = listOf(
            Coach("Jürgen Klopp", "DE", "Liverpool"),
            Coach("Pep Guardiola", "ES", "Barcelona"),
            Coach("Jose Mourinho", "PR", "Real Madrid"),
            Coach("Roberto Mancini", "IT", "Inter"),
            Coach("Carlo Ancelotti","IT","AC Milan")
        )

        val teams = listOf(
            Team("Liverpool","EN"),
            Team("Barcelona","ES"),
            Team("Real Madrid","ES"),
            Team("Inter","IT"),
            Team("AC Milan","IT"),
        )

        val championShips = listOf(
            ChampionShip("Copa America"),
            ChampionShip("UEFA Champions League"),
            ChampionShip("UEFA Europa League"),
            ChampionShip("UEFA Super Cup"),
            ChampionShip("UEFA Euro 2020"),
            ChampionShip("Fifa World Cup"),
            ChampionShip("Premier League ChampionShip"),
            ChampionShip("La Liga ChampionShip"),
            ChampionShip("Serie A ChampionShip")
        )

        val players = listOf(
            Player("Ronaldinho",40,"Barcelona","BR"),
            Player("Steven Gerard",30,"Liverpool","EN"),
            Player("Cristiano Ronaldo",25,"Real Madrid","PR"),
            Player("Andrea Pirlo",35,"AC Milan","IT"),
            Player("Paolo Maldini",40,"AC Milan","IT"),
            Player("Javier Zanetti",45,"Inter","AR"),
            Player("Milan Baros",40,"Liverpool","CZ"),
            Player("Xavi",40,"Barcelona","ES"),
            Player("Ricardo Kaka",37,"AC Milan","BR"),
            )

        val playerChampionShipRelations = listOf(
            PlayerChampionShipCrossRef("Ronaldinho","Copa America"),
            PlayerChampionShipCrossRef("Ronaldinho","Fifa World Cup"),
            PlayerChampionShipCrossRef("Steven Gerard","UEFA Super Cup"),
            PlayerChampionShipCrossRef("Steven Gerard","UEFA Europa League"),
            PlayerChampionShipCrossRef("Steven Gerard","Fifa World Cup"),
            PlayerChampionShipCrossRef("Andrea Pirlo","Fifa World Cup"),
            PlayerChampionShipCrossRef("Cristiano Ronaldo","Fifa World Cup"),
            PlayerChampionShipCrossRef("Cristiano Ronaldo","UEFA Euro 2020"),
            PlayerChampionShipCrossRef("Cristiano Ronaldo","UEFA Super Cup"),
            PlayerChampionShipCrossRef("Cristiano Ronaldo","La Liga ChampionShip"),
            PlayerChampionShipCrossRef("Cristiano Ronaldo","Premier League ChampionShip"),
            PlayerChampionShipCrossRef("Paolo Maldini","UEFA Super Cup"),
            PlayerChampionShipCrossRef("Paolo Maldini","Serie A ChampionShip"),
            PlayerChampionShipCrossRef("Milan Baros","Premier League ChampionShip"),
            PlayerChampionShipCrossRef("Milan Baros","UEFA Super Cup"),
            PlayerChampionShipCrossRef("Milan Baros","UEFA Super Cup"),
            PlayerChampionShipCrossRef("Javier Zanetti","UEFA Super Cup"),
            PlayerChampionShipCrossRef("Javier Zanetti","UEFA Europa League"),
            PlayerChampionShipCrossRef("Javier Zanetti","UEFA Champions League"),
            PlayerChampionShipCrossRef("Javier Zanetti","Serie A ChampionShip"),
            PlayerChampionShipCrossRef("Xavi","La Liga ChampionShip"),
            PlayerChampionShipCrossRef("Xavi","UEFA Europa League"),
            PlayerChampionShipCrossRef("Xavi","UEFA Super Cup"),
            PlayerChampionShipCrossRef("Xavi","UEFA Champions League"),
            PlayerChampionShipCrossRef("Xavi","Fifa World Cup"),
            PlayerChampionShipCrossRef("Ricardo Kaka","Fifa World Cup"),
            PlayerChampionShipCrossRef("Ricardo Kaka","UEFA Super Cup"),
            PlayerChampionShipCrossRef("Ricardo Kaka","UEFA Champions League"),
        )
        lifecycleScope.launch {
            coachs.forEach { dao.insertCoach(it) }
            teams.forEach { dao.insertTeam(it) }
            players.forEach { dao.insertPlayer(it) }
            championShips.forEach { dao.insertChampionShip(it) }

            playerChampionShipRelations.forEach { dao.insertPlayerChampionShipCrossRef(it) }

            val teamWithCoach = dao.getTeamAndCoachWithTeamName("AC Milan")

            val teamWithPlayers = dao.getTeamWithPlayers("AC Milan")
        }


    }
}
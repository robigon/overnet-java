/**
 * TeamItem.java
 *
 * robgion
 * www.2clever.it
 * 
 * 26 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.j2se.java8.streams;

import java.util.stream.Stream;

/**
 * @author robgion
 *
 */
public class TeamItem {

	private String team;
	private int points;
	
	public TeamItem(String team, int points) {
        this.team = team;
        this.points = points;
    }
 
    public String getTeam() {
        return team;
    }
 
    public int getPoints() {
        return points;
    }
 
    @Override
    public String toString() {
        return points + "\t" + team;
    }
    
    /**
     * Metodo statico che esegue il parsing di una stringa e, in base ai goal segnati dalle due squadre, 
     * restutuisce uno stream di oggetti TeamItem. 
     * 
     * In caso di vittoria vengono assegnati tre punti alla squadra vincente altrimenti c’è un pareggio
     * e quindi ognuna delle due squadre ottiene un punto
     * 
     * @param s
     * @return
     */
	public static Stream<TeamItem> createItems(String s) {
	    String[] split = s.split("\t");
	    int goal1 = Integer.parseInt(split[3]);
	    int goal2 = Integer.parseInt(split[4]);
	 
	    if (goal1 > goal2) {
	        return Stream.of(new TeamItem(split[1], 3));
	    } else if (goal1 == goal2) {
	        return Stream.of(
	                new TeamItem(split[1], 1),
	                new TeamItem(split[2], 1)
	        );
	    } else {
	        return Stream.of(new TeamItem(split[2], 3));
	    }
	}
	
	public static int compare(TeamItem t1, TeamItem t2){
	    int r = t2.points - t1.points;
	    if (r == 0) {
	        r = t1.team.compareTo(t2.team);
	    }
	    return r;
	}
}

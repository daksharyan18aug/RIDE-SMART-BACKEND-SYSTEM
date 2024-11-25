package admin;

import java.util.HashMap;

public class AdminComponent {
    private HashMap<String, Agent> agents = new HashMap<>();

    public void registerAgent(String agentID, String password) {
        String hashedPassword = hashPassword(password);
        Agent agent = new Agent(agentID, hashedPassword, false);
        agents.put(agentID, agent);
        System.out.println("Agent registered: " + agentID);
    }

    public boolean loginAgent(String agentID, String password) {
        String hashedPassword = hashPassword(password);
        Agent agent = agents.get(agentID);
        if (agent != null && agent.getPassword().equals(hashedPassword)) {
            agent.setLoggedIn(true);
            System.out.println("Login successful for: " + agentID);
            return true;
        }
        System.out.println("Login failed for: " + agentID);
        return false;
    }

    public void logoutAgent(String agentID) {
        Agent agent = agents.get(agentID);
        if (agent != null && agent.isLoggedIn()) {
            agent.setLoggedIn(false);
            System.out.println("Logout successful for: " + agentID);
        } else {
            System.out.println("Agent is not logged in: " + agentID);
        }
    }

    private String hashPassword(String password) {
        return Integer.toString(password.hashCode());
    }

    class Agent {
        private String agentID;
        private String password;
        private boolean loggedIn;

        public Agent(String agentID, String password, boolean loggedIn) {
            this.agentID = agentID;
            this.password = password;
            this.loggedIn = loggedIn;
        }

        public String getPassword() {
            return password;
        }

        public boolean isLoggedIn() {
            return loggedIn;
        }

        public void setLoggedIn(boolean loggedIn) {
            this.loggedIn = loggedIn;
        }
    }
}

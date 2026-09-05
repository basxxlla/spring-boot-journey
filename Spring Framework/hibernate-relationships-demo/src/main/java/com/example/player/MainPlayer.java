package com.example.player;

public class MainPlayer {
    public static void main(String[] args) {
        PlayerDAO playerDAO = new PlayerDAO(HibernateUtil.getSessionFactory());

        // 1. Save (create) with sample data
        Player player = new Player("Lionel Rossi", 27, true);
        Long id = playerDAO.save(player);
        System.out.println("Saved -> " + player);

        // 2. Get by id
        Player fetched = playerDAO.getById(id);
        System.out.println("Fetched -> " + fetched);

        // 3. Update
        fetched.setAge(28);
        fetched.setStatus(false);
        playerDAO.update(fetched);
        System.out.println("Updated -> " + playerDAO.getById(id));

        // 4. Delete
        playerDAO.delete(id);
        System.out.println("Deleted player with id " + id);
        System.out.println("Get after delete (should be null) -> " + playerDAO.getById(id));

        HibernateUtil.shutdown();
    }
}

package com.project.personal_budget_manager.service;


import com.project.personal_budget_manager.model.Notification;
import com.project.personal_budget_manager.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class that handles business logic for managing notifications.
 */
@Service
public class NotificationService {

    // Autowiring repository to perform CRUD operations
    @Autowired
    private NotificationRepository notificationRepository;

    /**
     * Adds a new notification to the database.
     * @param notification The notification object to be added.
     * @return The saved notification object.
     */
    public Notification addNotification(Notification notification) {
        // Save the notification to the database and return it
        return notificationRepository.save(notification);
    }

    /**
     * Retrieves all notifications from the database.
     * @return A list of all notifications.
     */
    public List<Notification> getAllNotifications() {
        // Fetch all notifications from the database
        return notificationRepository.findAll();
    }

    /**
     * Retrieves a specific notification by its ID.
     * @param id The ID of the notification.
     * @return The notification with the given ID, wrapped in an Optional.
     */
    public Optional<Notification> getNotificationById(Long id) {
        // Find the notification by its ID
        return notificationRepository.findById(id);
    }

    /**
     * Updates an existing notification in the database.
     * @param notification The updated notification object.
     * @return The updated notification object.
     */
    public Notification updateNotification(Notification notification) {
        // Save the updated notification to the database and return it
        return notificationRepository.save(notification);
    }

    /**
     * Deletes a notification from the database by its ID.
     * @param id The ID of the notification to be deleted.
     */
    public void deleteNotification(Long id) {
        // Remove the notification from the database
        notificationRepository.deleteById(id);
    }
}


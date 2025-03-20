package dyeggo.silva.dio.notification_email_api.repository;

import dyeggo.silva.dio.notification_email_api.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface FeedbackRepositoty extends JpaRepository<Feedback, Integer> {
}

ALTER TABLE repair_tickets
    ADD acceptance_tester_id BIGINT NULL;

ALTER TABLE repair_tickets
    ADD CONSTRAINT FK_REPAIR_TICKETS_ON_ACCEPTANCE_TESTER FOREIGN KEY (acceptance_tester_id) REFERENCES users (id)   ON DELETE SET NULL ON UPDATE SET NULL;
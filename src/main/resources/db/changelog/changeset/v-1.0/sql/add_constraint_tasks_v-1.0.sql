ALTER TABLE tasks
ADD CONSTRAINT fk_task_worker
FOREIGN KEY (performer) REFERENCES workers(id)
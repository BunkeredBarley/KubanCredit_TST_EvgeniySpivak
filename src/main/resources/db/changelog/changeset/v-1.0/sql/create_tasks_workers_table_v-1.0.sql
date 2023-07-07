CREATE TABLE task_worker (
    task_id int REFERENCES tasks(id),
    worker_id int REFERENCES workers(id),

    CONSTRAINT task_worker_pkey PRIMARY KEY (task_id, worker_id)
)
INSERT INTO management_users
(organization_id, role_id, username, password_hash, enabled, created_at, updated_at)
VALUES
    (NULL, (SELECT id FROM roles WHERE name = 'PLATFORM_ADMIN'),
     'platform-admin',
     '$2y$10$E/Qaay/8upXkzOQivswrx.i9qy/DkCljpmBCfZZpLIDCo.SZnNybO',
     TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO management_users
(organization_id, role_id, username, password_hash, enabled, created_at, updated_at)
VALUES
    (NULL, (SELECT id FROM roles WHERE name = 'GATEWAY_SERVICE'),
     'gateway-service',
     '$2y$10$kgkpKYK3zLNzLV54ObZbee68JvjRjy79J6kATSfD0grUXKDd6jxOO',
     TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
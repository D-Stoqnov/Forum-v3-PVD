use posts;

-- Попълване на таблица categories
INSERT INTO categories (name) VALUES
                                  ('Cars'),
                                  ('Food'),
                                  ('Medicine'),
                                  ('Technology'),
                                  ('Travel'),
                                  ('Sports');

-- Попълване на таблица users
INSERT INTO users (username, password, first_name, last_name, email, is_admin) VALUES
                                                                                   ('user1', 'pass1', 'John', 'Doe', 'john@example.com', 1),
                                                                                   ('user2', 'pass2', 'Jane', 'Doe', 'jane@example.com', 0),
                                                                                   ('user3', 'pass3', 'Bob', 'Smith', 'bob@example.com', 0);

-- Попълване на таблица posts
INSERT INTO posts (title, content, category_id, created_by) VALUES
                                                                ('Best Sports Car', 'Discussing the latest sports cars in the market.', 1, 1),
                                                                ('Delicious Recipes', 'Share your favorite recipes and cooking tips.', 2, 2),
                                                                ('New Medical Discoveries', 'Latest breakthroughs in medicine and healthcare.', 3, 3),
                                                                ('Top Tech Gadgets', 'Explore and discuss the coolest technology gadgets.', 4, 1),
                                                                ('Travel Destinations', 'Share your travel experiences and recommendations.', 5, 2),
                                                                ('Football News', 'Discussing the latest football matches and news.', 6, 3);








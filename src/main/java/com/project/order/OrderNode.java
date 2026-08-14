package com.project.order;

public class OrderNode {
        Order data;
        OrderNode left;
        OrderNode right;

        public OrderNode(Order data) {
            this.data = data;
        }
    }

    class OrderBST {

        OrderNode root;

        // TODO: Fix insertion logic
        public void insert(Order order) {
            root = insertRecursive(root, order);
        }

        private OrderNode insertRecursive(OrderNode current, Order order) {

            if (current == null) {
                return new OrderNode(order);
            }

            // TODO: Fix the comparisons below. - DONE
            // Note: priorityLevel values can repeat across orders.
            // Decide where duplicates should go and be ready to explain your choice.

            // I decide to put the duplicates and lower priority orders to the left side
            // if they are less then or equal to the parent node, else the
            // higher priority orders go right.
            if (order.getPriorityLevel() <= current.data.getPriorityLevel()) {
                current.left = insertRecursive(current.left, order);
            } else {
                current.right = insertRecursive(current.right, order);
            }
            return current;
        }

        // TODO: Implement inorder traversal - DONE
        public void inorder(OrderNode node) {
            if (node == null) {
                return;
            }
            inorder(node.left);
            System.out.println(node.data.getPriorityLevel());
            inorder(node.right);
        }


        // TODO: Fix highest priority logic - DONE

        // refactored this method from current.left to current.right to find the highest priority order.
        public Order findHighest() {
            OrderNode current = root;

            while (current.right != null) {
                current = current.right;
            }

            return current.data;
        }

        // TODO: Write findLowest priority logic

        public Order findLowest() {
            OrderNode current = root;
            while(current.left != null){
                current = current.left;
            }
            return current.data;
        }
    }

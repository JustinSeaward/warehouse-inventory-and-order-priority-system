package com.project.order;

import java.util.ArrayList;
import java.util.List;

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

        public List<Order> getInorderOrders(){
            List<Order> sortedOrders = new ArrayList<>();
            inorder(root, sortedOrders);
            return sortedOrders;
        }

        // TODO: Implement inorder traversal - DONE
        public void inorder(OrderNode node, List<Order> list) {
            if (node == null) {
                return;
            }
            inorder(node.left, list);
            list.add(node.data);
            inorder(node.right, list);
        }

        // TODO: Fix highest priority logic - DONE
        // refactored this method from current.left to current.right to find the highest priority order.
        public Order findHighest() {
            OrderNode current = root;
            if(current == null){
                return null;
            }
            while (current.right != null) {
                current = current.right;
            }

            return current.data;
        }

        // TODO: Write findLowest priority logic - DONE

        public Order findLowest() {
            OrderNode current = root;
            if(current == null){
                return null;
            }
            while(current.left != null){
                current = current.left;
            }
            return current.data;
        }
    }

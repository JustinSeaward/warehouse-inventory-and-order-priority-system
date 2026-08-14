Binary Search Tree
•	Why does an inOrder traversal of a BST return sorted results? Explain in your own words.
    - An inOrder traversal returns sorted results because the traversal works by visiting the left child, then printing the current node, and finally visiting the right child, you guarantee that the tree is read from the smallest value to the largest.

•	What happens to the tree if you insert values in order (1,2,3,4,5)? How does this affect performance?

•	What is the difference between average and worst-case time complexity for a BST?

•	Where would you place duplicate priority values in your tree? Explain your choice.
    - I decide to put the duplicates and lower priority orders to the left side
      if they are less then or equal to the parent node, else the
      higher priority orders go right.


Sorting Algorithm
•	Explain how your sorting algorithm works step-by-step using a small example.
•	What is the time complexity of your algorithm?
•	When would your sorting algorithm perform well?
•	Why is your sorting algorithm ideal or not ideal for very large datasets?


System Design
•	Why might you choose to sort data in your application instead of the database?
•	What is one advantage of using a BST in this system?
•	What is one limitation of your current design?

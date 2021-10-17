# Triangles in Graph
### COL106 Course Assignment
<!--## Problem Statement
Maintain a data structure  to count and store-->
## Requirements
1. ADD_TRIANGLE()-	Checks if the traingle can be created or not. If possible then it creates a new triangle accoording to the given coordinates and adds it to the list alltriangles. Simaltaneously it updates the alledges and allpoints list.
	
2. TYPE_MESH()-	It returns 1 if all edges are a part of exactly two triangles.
3. BOUNDARY_EDGES()- Returns an array of edges that are a part of exactly one triangle. It sorts the edges based on their length.
4. COUNT_CONNECTED_COMPONENTS()- Returns the number of connected components.It uses breadth first traversal.
5. NEIGHBORS_OF_TRIANGLE()-	Returns an arry of the neighbors of the given triangle using the triangle list maintained in each triangle.	
6. EDGE_NEIGHBOR_TRIANGLE()- Returns an array of the edges of the triangle.
7. VERTEX_NEIGHBOR_TRIANGLE()- Returns an array of the vertices of the triangle.
8. EXTENDED_NEIGHBOR_TRIANGLE()- Returns all the triangles which share vertices with the vertices of the given triangle and sorts the array based on the insertion order of   triangles.
9. INCIDENT_TRIANGLES()- Returns an array of triangles that have the given vertex(if it exists) sorted based on the order of their insertion.
10. NEIGHBORS_OF_POINT()-	Returns an array of adjacent neighnors of the given point(if it exists) 
11. EDGE_NEIGHBORS_OF_POINT()- Returns an array of edge neighbors of the given point(if it exists) using the edgelist maintained in each point.
12. FACE_NEIGHBORS_OF_POINT()- similar to incident triangles query
13. IS_CONNECTED()- checks if the given two triangles are connected.(it uses depth first traversal)
14.	TRIANGLE_NEIGHBOR_OF_EDGE()- Returns an array of triangles which contain an edge similar to the given edge and sorts the array based on the insertion order of triangles.
15. MAXIMUM_DIAMETER()-	Returns the maximum of all the shortest distances between any two triangles of a connected component which has maximum number of triangles. It uses bft technique.
16.	CENTROID()-	Returns an array of the average of all the vertices of each component. 
17. CENTROID_OF_COMPONENT()-	Returns the average of all vertices of the component containing the given point.
18.	CLOSEST_COMPONENTS()-	Returns the minimum distance between any two vertices of different components.

## Implementation
**Graph** : Coordinates of triangles were stored in a Graph and all the complex queries were performed on this data structure.

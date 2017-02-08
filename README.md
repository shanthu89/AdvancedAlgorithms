#Graph Coloring Algorithm - Brelaz Dsatur Implementaion
----------------------------------------------------------------------------------------------------------------------------------
###Implementation
----------------------------------------------------------------------------------------------------------------------------------
This folder contains code for Implementation of Brélaz’s Dsatur algorithm following the paper "New methods to color the vertices of a graph".
Brelaz paper can be found here: http://dl.acm.org/citation.cfm?doid=359094.359101.

For this implementaion,random graphs were generated using the strategy described in Section 3.1 of Brélaz’s paper, with |𝑉|=10, 20, 30,….500 vertices.
Random graphs generated were colored using Brelaz algorithm and running time and colors needed to color graphs of varying edge density were computed.

My implementation takes complexity O(|V|) * O (|E|). 

Density of graphs created according to the paper:
Group 1 range = 0.73 to 0.82,Group 2 range = 0.61 to 0.72, Group 3 range = 0.44 to 0.59, Group 4 range = 0.26 to 0.34


----------------------------------------------------------------------------------------------------------------------------------
###Instruction to RunCode:
----------------------------------------------------------------------------------------------------------------------------------
I have run the algorithm for 500 vertices to draw the graph for each of the four group.
Please change the "maxVertices" variable in TCSS543.java according to the number of vertices you wish to run.

----------------------------------------------------------------------------------------------------------------------------------
###Results:
----------------------------------------------------------------------------------------------------------------------------------
Group 1 has higher density so the graphs are dense i.e they have more number of edges added so the computation time and colors used is higher. 
We know that for calculation of saturation degree, picking colors to be used we need to go through the connected adjacent vertices for each vertex. So they take a longer time for computation and hence longer running time for coloring the graph.
Group 2 has lower density than group 4, almost 3/4th to 1/2h of edges connected. So less time and colors than group 1.
Group 3 has almost 1/2th of edges connected so they take less time than group-2 for computation.
Group 4 on the other hand is 0.26 to 0.34 density which is very sparse graph having almost 1/4th edges connected only. So their computation takes a lesser time and fewer colors.

Thus we can know that, the denser the graph the more time for computation and requires more number of colors.

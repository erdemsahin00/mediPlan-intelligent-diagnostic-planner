# MediPlan: Intelligent Diagnostic Planner

## 📌 Project Overview
MediPlan is an automated diagnostic planning system developed in **Java (OpenJDK 11)** designed to optimize patient clinical workups and hospital costs. Inspired by early medical information challenges (circa 1978), the project models complex hierarchies of RAW, DERIVED, and COMPOSITE medical tests as a **Directed Acyclic Graph (DAG)**.

The engine solves critical redundancies in test execution paths by leveraging two distinct **Dynamic Programming (DP)** paradigms.

## 🧠 Algorithmic Architecture & DP Implementation

### 1. Cost Preprocessing (Step 2)
* Iterates over `DERIVED` tests to dynamically count distinct non-invasive/invasive collection procedures (`BLOOD`, `URINE`, `TISSUE`) from their direct dependencies to assign baseline processing costs[cite: 1].

### 2. Patient Burden Analysis (Top-Down Memoized DP - Step 3)
* **Objective:** Computes the minimal physical burden on a patient for a single target score[cite: 1].
* **Method:** Implements a lazy-evaluation recursion with a **Memoization Table** tracking unique sample types reachable in the sub-tree to avoid redundant resource re-evaluation[cite: 1].

### 3. Naive Hospital Cost (Bottom-Up Tabulated DP - Step 4)
* **Objective:** Establishes a baseline cost tracking every dependency chain independently[cite: 1].
* **Method:** Runs a **Depth-First Search (DFS)** to generate a strict **Topological Order** of the DAG[cite: 1]. Then, eagerly evaluates a multi-target tabulation cost table in $O(1)$ lookup time[cite: 1].

### 4. Traceback & Combined Execution Plan (Step 5)
* Performs a combined structural traceback over the reachable sub-graph to eliminate shared redundancy[cite: 1]. Constructs an optimized plan ensuring each test is performed **at most once**, reducing overall hospital expenditure[cite: 1].

## 🛠️ Technology Stack & Tools
* **Language:** Java (OpenJDK 11)[cite: 1]
* **Data Structures:** Custom Directed Graphs, Memoization Maps, Tabulation Arrays
* **XML Parsing:** Built-in standard `javax.xml.parsers` (No external dependencies)[cite: 1]

---
*Disclaimer: This repository is part of the BBM204 Software Practicum II course assignment at Hacettepe University Computer Engineering Department[cite: 1]. All test parameters and hospital cost logic are fictional constructs designed for algorithmic evaluation[cite: 1].*

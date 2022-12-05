(************************************************************
 * Result by: IMITATOR 3.4-beta "Cheese Durian" (build develop/7750055)
 * Model    : 'testEFExemplify1Pneg.imi'
 * Generated: Wed Nov 2, 2022 10:01:13
 * Command  : imitator testEFExemplify1Pneg.imi testEFExemplify1Pneg.imiprop -comparison equality -merge none
 ************************************************************)


------------------------------------------------------------
Number of IPTAs                         : 1
Number of clocks                        : 2
Has invariants?                         : true
Has clocks with rate <>1?               : false
Has complex updates?                    : false
L/U subclass                            : L-PTA
Bounded parameters?                     : true
Has silent actions?                     : false
Is strongly deterministic?              : true
Number of parameters                    : 1
Number of discrete variables            : 0
Number of actions                       : 2
Total number of locations               : 3
Average locations per IPTA              : 3.0
Total number of transitions             : 2
Average transitions per IPTA            : 2.0
------------------------------------------------------------

BEGIN RESULT

(************************************************************)
 Run #1

 Valuation:
  p = 1

 Other valuations with equivalent (discrete) run:
 4 > p
& p >= 0

 Run nature: valid run

 Run:
{
	"run": {
		"nature": "concrete",
		"valuation": {
			"p": "1"
			},
		"steps": [
			{
			"state": {
				"location": {
					"specification": "l1"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "0",
					"global_time": "0"
				},
				"flows": {
					"x": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "1",
				"action": "a1",
				"transitions": [
					{
					"transition": {
						"PTA": "specification",
						"guard": " 2 >= x",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"specification": "l2"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "1",
					"global_time": "1"
				},
				"flows": {
					"x": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1",
				"action": "a2",
				"transitions": [
					{
					"transition": {
						"PTA": "specification",
						"guard": " x > p",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"specification": "lT"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "2",
					"global_time": "2"
				},
				"flows": {
					"x": "1", 
					"global_time": "1"
				}
			}
			}
		]
	}
}
(************************************************************)


(************************************************************)
 Run #2

 Valuation:
  p = 4

 Other valuations with equivalent (discrete) run:
 p = 4

 Run nature: impossible run

 Run:
{
	"run": {
		"nature": "negative",
		"valuation": {
			"p": "4"
			},
		"steps": [
			{
			"state": {
				"location": {
					"specification": "l1"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "4",
					"x": "0",
					"global_time": "0"
				},
				"flows": {
					"x": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "1",
				"action": "a1",
				"transitions": [
					{
					"transition": {
						"PTA": "specification",
						"guard": " 2 >= x",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"specification": "l2"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "4",
					"x": "1",
					"global_time": "1"
				},
				"flows": {
					"x": "1", 
					"global_time": "1"
				}
			}
			}
			{
			"transition": {
				"nature": "impossible",
				"duration": "1",
				"action": "a2"
			}
			},
			{
			"state": {
				"location": {
					"specification": "lT"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "4",
					"x": "2",
					"global_time": "2"
				},
				"flows": {
					"x": "1", 
					"global_time": "1"
				}
			}
			}
		]
	}
}
(************************************************************)

END RESULT

------------------------------------------------------------
Number of states                        : 3
Number of transitions                   : 2
Number of computed states               : 3
Total computation time                  : 0.001 second
States/second in state space            : 2460.9 (3/0.001 second)
Computed states/second                  : 2460.9 (3/0.001 second)
Estimated memory                        : 2.909 MiB (i.e., 381312 words of size 8)
------------------------------------------------------------

------------------------------------------------------------
 Statistics: Algorithm counters
------------------------------------------------------------
main algorithm + parsing                : 0.001 second
main algorithm                          : 0.001 second
------------------------------------------------------------
 Statistics: Parsing counters
------------------------------------------------------------
model parsing and converting            : 0.000 second
------------------------------------------------------------
 Statistics: State computation counters
------------------------------------------------------------
number of constraints comparisons       : 0
number of state comparisons             : 0
number of new states <= old             : 0
number of new states >= old             : 0
StateSpace.merging attempts             : 0
StateSpace.merges                       : 0
StateSpace.Merge time                   : 0.000 second
StateSpace.Merge (reconstruct state space): 0.000 second
------------------------------------------------------------
 Statistics: Graphics-related counters
------------------------------------------------------------
state space drawing                     : 0.000 second
------------------------------------------------------------
 Statistics: Global counter
------------------------------------------------------------
total                                   : 0.001 second
------------------------------------------------------------
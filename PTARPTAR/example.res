(************************************************************
 * Result by: IMITATOR 3.4-beta "Cheese Durian" (build ?????/?????)
 * Model    : '/imitator/fff/example.imi'
 * Generated: Fri Dec 30, 2022 11:58:32
 * Command  : /imitator/bin/imitator /imitator/fff/example.imi /imitator/fff/exampleProp.imiprop -comparison equality -merge none
 ************************************************************)


------------------------------------------------------------
Number of IPTAs                         : 2
Number of clocks                        : 3
Has invariants?                         : true
Has clocks with rate <>1?               : false
Has complex updates?                    : false
L/U subclass                            : not L/U
Bounded parameters?                     : true
Has silent actions?                     : false
Is strongly deterministic?              : true
Number of parameters                    : 1
Number of discrete variables            : 0
Number of actions                       : 4
Total number of locations               : 6
Average locations per IPTA              : 3.0
Total number of transitions             : 6
Average transitions per IPTA            : 3.0
------------------------------------------------------------

BEGIN RESULT

(************************************************************)
 Run #1

 Valuation:
  p = 1

 Other valuations with equivalent (discrete) run:
 2 >= p
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
					"machine": "off", 
					"user": "idle"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"uTime": "0",
					"wTime": "0",
					"global_time": "0"
				},
				"flows": {
					"uTime": "1", 
					"wTime": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "1",
				"action": "turnOn",
				"transitions": [
					{
					"transition": {
						"PTA": "machine",
						"guard": "True",
						"updates": {
							"uTime": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "user",
						"guard": "True",
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
					"machine": "on", 
					"user": "useMachine"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"uTime": "0",
					"wTime": "1",
					"global_time": "1"
				},
				"flows": {
					"uTime": "1", 
					"wTime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1",
				"action": "xdd",
				"transitions": [
					{
					"transition": {
						"PTA": "machine",
						"guard": " uTime >= p",
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
					"machine": "waitForInput", 
					"user": "useMachine"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"uTime": "1",
					"wTime": "2",
					"global_time": "2"
				},
				"flows": {
					"uTime": "1", 
					"wTime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "noInputRec",
				"transitions": [
					{
					"transition": {
						"PTA": "machine",
						"guard": " wTime >= 2",
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
					"machine": "errorState", 
					"user": "useMachine"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"uTime": "1",
					"wTime": "2",
					"global_time": "2"
				},
				"flows": {
					"uTime": "1", 
					"wTime": "1", 
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
  p = 5/2

 Other valuations with equivalent (discrete) run:
 p > 2
& 3 >= p

 Run nature: impossible run

 Run:
{
	"run": {
		"nature": "negative",
		"valuation": {
			"p": "5/2"
			},
		"steps": [
			{
			"state": {
				"location": {
					"machine": "off", 
					"user": "idle"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "5/2",
					"uTime": "0",
					"wTime": "0",
					"global_time": "0"
				},
				"flows": {
					"uTime": "1", 
					"wTime": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "turnOn",
				"transitions": [
					{
					"transition": {
						"PTA": "machine",
						"guard": "True",
						"updates": {
							"uTime": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "user",
						"guard": "True",
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
					"machine": "on", 
					"user": "useMachine"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "5/2",
					"uTime": "0",
					"wTime": "0",
					"global_time": "0"
				},
				"flows": {
					"uTime": "1", 
					"wTime": "1", 
					"global_time": "1"
				}
			}
			}
			{
			"transition": {
				"nature": "impossible",
				"duration": "1",
				"action": "xdd"
			}
			},
			{
			"state": {
				"location": {
					"machine": "waitForInput", 
					"user": "useMachine"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "5/2",
					"uTime": "1",
					"wTime": "1",
					"global_time": "1"
				},
				"flows": {
					"uTime": "1", 
					"wTime": "1", 
					"global_time": "1"
				}
			}
			}
			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "noInputRec"
			}
			},
			{
			"state": {
				"location": {
					"machine": "errorState", 
					"user": "useMachine"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "5/2",
					"uTime": "2",
					"wTime": "2",
					"global_time": "2"
				},
				"flows": {
					"uTime": "1", 
					"wTime": "1", 
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
Number of states                        : 5
Number of transitions                   : 5
Number of computed states               : 6
Total computation time                  : 0.012 second
States/second in state space            : 402.1 (5/0.012 second)
Computed states/second                  : 482.6 (6/0.012 second)
Estimated memory                        : 3.303 MiB (i.e., 433061 words of size 8)
------------------------------------------------------------

------------------------------------------------------------
 Statistics: Algorithm counters
------------------------------------------------------------
main algorithm + parsing                : 0.020 second
main algorithm                          : 0.012 second
------------------------------------------------------------
 Statistics: Parsing counters
------------------------------------------------------------
model parsing and converting            : 0.006 second
------------------------------------------------------------
 Statistics: State computation counters
------------------------------------------------------------
number of constraints comparisons       : 2
number of state comparisons             : 2
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
total                                   : 0.020 second
------------------------------------------------------------
(************************************************************
 * Result by: IMITATOR 3.4-beta "Cheese Durian" (build ?????/?????)
 * Model    : '/imitator/fff/fisch93.imi'
 * Generated: Sat Jan 7, 2023 22:16:20
 * Command  : /imitator/bin/imitator /imitator/fff/fisch93.imi /imitator/fff/fisch93prop.imiprop -comparison equality -merge none
 ************************************************************)


------------------------------------------------------------
Number of IPTAs                         : 3
Number of clocks                        : 3
Has invariants?                         : false
Has clocks with rate <>1?               : false
Has complex updates?                    : false
L/U subclass                            : L-PTA
Bounded parameters?                     : false
Has silent actions?                     : true
Is strongly deterministic?              : true
Number of parameters                    : 1
Number of discrete variables            : 0
Number of actions                       : 16
Total number of locations               : 13
Average locations per IPTA              : 4.3
Total number of transitions             : 32
Average transitions per IPTA            : 10.6
------------------------------------------------------------

BEGIN RESULT

(************************************************************)
 Run #1

 Valuation:
  a = 1

 Other valuations with equivalent (discrete) run:
 5 > a

 Run nature: valid run

 Run:
{
	"run": {
		"nature": "concrete",
		"valuation": {
			"a": "1"
			},
		"steps": [
			{
			"state": {
				"location": {
					"lock": "lock0", 
					"P1": "P1_0", 
					"P2": "P2_0"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "0",
					"x_prime": "0",
					"global_time": "0"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/16",
				"action": "(silent)",
				"transitions": [
					{
					"transition": {
						"PTA": "P2",
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
					"lock": "lock0", 
					"P1": "P1_0", 
					"P2": "P2_1"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "1/16",
					"x_prime": "1/16",
					"global_time": "1/16"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/16",
				"action": "(silent)",
				"transitions": [
					{
					"transition": {
						"PTA": "P1",
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
					"lock": "lock0", 
					"P1": "P1_1", 
					"P2": "P2_1"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "1/8",
					"x_prime": "1/8",
					"global_time": "1/8"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/8",
				"action": "is_0_prime",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P2",
						"guard": "True",
						"updates": {
							"x_prime": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"lock": "lock0", 
					"P1": "P1_1", 
					"P2": "P2_2"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "1/4",
					"x_prime": "0",
					"global_time": "1/4"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/4",
				"action": "is_0",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P1",
						"guard": "True",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"lock": "lock0", 
					"P1": "P1_2", 
					"P2": "P2_2"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "0",
					"x_prime": "1/4",
					"global_time": "1/2"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "5/2",
				"action": "set_2_prime",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P2",
						"guard": " x_prime > 2 AND 3 > x_prime",
						"updates": {
							"x_prime": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"lock": "lock2", 
					"P1": "P1_2", 
					"P2": "P2_3"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "5/2",
					"x_prime": "0",
					"global_time": "3"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "set_1",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P1",
						"guard": " x > 2 AND 3 > x",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"lock": "lock1", 
					"P1": "P1_3", 
					"P2": "P2_3"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "0",
					"x_prime": "0",
					"global_time": "3"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "3/2",
				"action": "is_1_prime",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P2",
						"guard": " 5 > x_prime AND x_prime > a",
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
					"lock": "lock1", 
					"P1": "P1_3", 
					"P2": "P2_4"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "3/2",
					"x_prime": "3/2",
					"global_time": "9/2"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/2",
				"action": "is_1",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P1",
						"guard": " 5 > x AND x > a",
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
					"lock": "lock1", 
					"P1": "P1_4", 
					"P2": "P2_4"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "2",
					"x_prime": "2",
					"global_time": "5"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
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
  a = 1

 Other valuations with equivalent (discrete) run:
 5 > a

 Run nature: valid run

 Run:
{
	"run": {
		"nature": "concrete",
		"valuation": {
			"a": "1"
			},
		"steps": [
			{
			"state": {
				"location": {
					"lock": "lock0", 
					"P1": "P1_0", 
					"P2": "P2_0"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "0",
					"x_prime": "0",
					"global_time": "0"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/16",
				"action": "(silent)",
				"transitions": [
					{
					"transition": {
						"PTA": "P2",
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
					"lock": "lock0", 
					"P1": "P1_0", 
					"P2": "P2_1"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "1/16",
					"x_prime": "1/16",
					"global_time": "1/16"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/16",
				"action": "(silent)",
				"transitions": [
					{
					"transition": {
						"PTA": "P1",
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
					"lock": "lock0", 
					"P1": "P1_1", 
					"P2": "P2_1"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "1/8",
					"x_prime": "1/8",
					"global_time": "1/8"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/8",
				"action": "is_0_prime",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P2",
						"guard": "True",
						"updates": {
							"x_prime": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"lock": "lock0", 
					"P1": "P1_1", 
					"P2": "P2_2"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "1/4",
					"x_prime": "0",
					"global_time": "1/4"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/4",
				"action": "is_0",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P1",
						"guard": "True",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"lock": "lock0", 
					"P1": "P1_2", 
					"P2": "P2_2"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "0",
					"x_prime": "1/4",
					"global_time": "1/2"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "5/2",
				"action": "set_2_prime",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P2",
						"guard": " x_prime > 2 AND 3 > x_prime",
						"updates": {
							"x_prime": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"lock": "lock2", 
					"P1": "P1_2", 
					"P2": "P2_3"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "5/2",
					"x_prime": "0",
					"global_time": "3"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "set_1",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P1",
						"guard": " x > 2 AND 3 > x",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"lock": "lock1", 
					"P1": "P1_3", 
					"P2": "P2_3"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "0",
					"x_prime": "0",
					"global_time": "3"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "3/2",
				"action": "is_1",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P1",
						"guard": " 5 > x AND x > a",
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
					"lock": "lock1", 
					"P1": "P1_4", 
					"P2": "P2_3"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "3/2",
					"x_prime": "3/2",
					"global_time": "9/2"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/2",
				"action": "is_1_prime",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P2",
						"guard": " 5 > x_prime AND x_prime > a",
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
					"lock": "lock1", 
					"P1": "P1_4", 
					"P2": "P2_4"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "2",
					"x_prime": "2",
					"global_time": "5"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}
		]
	}
}
(************************************************************)


(************************************************************)
 Run #3

 Valuation:
  a = 1

 Other valuations with equivalent (discrete) run:
 5 > a

 Run nature: valid run

 Run:
{
	"run": {
		"nature": "concrete",
		"valuation": {
			"a": "1"
			},
		"steps": [
			{
			"state": {
				"location": {
					"lock": "lock0", 
					"P1": "P1_0", 
					"P2": "P2_0"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "0",
					"x_prime": "0",
					"global_time": "0"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/8",
				"action": "(silent)",
				"transitions": [
					{
					"transition": {
						"PTA": "P2",
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
					"lock": "lock0", 
					"P1": "P1_0", 
					"P2": "P2_1"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "1/8",
					"x_prime": "1/8",
					"global_time": "1/8"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/8",
				"action": "(silent)",
				"transitions": [
					{
					"transition": {
						"PTA": "P1",
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
					"lock": "lock0", 
					"P1": "P1_1", 
					"P2": "P2_1"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "1/4",
					"x_prime": "1/4",
					"global_time": "1/4"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/4",
				"action": "is_0",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P1",
						"guard": "True",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"lock": "lock0", 
					"P1": "P1_2", 
					"P2": "P2_1"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "0",
					"x_prime": "1/2",
					"global_time": "1/2"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/4",
				"action": "is_0_prime",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P2",
						"guard": "True",
						"updates": {
							"x_prime": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"lock": "lock0", 
					"P1": "P1_2", 
					"P2": "P2_2"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "1/4",
					"x_prime": "0",
					"global_time": "3/4"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "9/4",
				"action": "set_2_prime",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P2",
						"guard": " x_prime > 2 AND 3 > x_prime",
						"updates": {
							"x_prime": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"lock": "lock2", 
					"P1": "P1_2", 
					"P2": "P2_3"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "5/2",
					"x_prime": "0",
					"global_time": "3"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "set_1",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P1",
						"guard": " x > 2 AND 3 > x",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"lock": "lock1", 
					"P1": "P1_3", 
					"P2": "P2_3"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "0",
					"x_prime": "0",
					"global_time": "3"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "3/2",
				"action": "is_1",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P1",
						"guard": " 5 > x AND x > a",
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
					"lock": "lock1", 
					"P1": "P1_4", 
					"P2": "P2_3"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "3/2",
					"x_prime": "3/2",
					"global_time": "9/2"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/2",
				"action": "is_1_prime",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P2",
						"guard": " 5 > x_prime AND x_prime > a",
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
					"lock": "lock1", 
					"P1": "P1_4", 
					"P2": "P2_4"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "2",
					"x_prime": "2",
					"global_time": "5"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}
		]
	}
}
(************************************************************)


(************************************************************)
 Run #4

 Valuation:
  a = 1

 Other valuations with equivalent (discrete) run:
 5 > a

 Run nature: valid run

 Run:
{
	"run": {
		"nature": "concrete",
		"valuation": {
			"a": "1"
			},
		"steps": [
			{
			"state": {
				"location": {
					"lock": "lock0", 
					"P1": "P1_0", 
					"P2": "P2_0"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "0",
					"x_prime": "0",
					"global_time": "0"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/8",
				"action": "(silent)",
				"transitions": [
					{
					"transition": {
						"PTA": "P2",
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
					"lock": "lock0", 
					"P1": "P1_0", 
					"P2": "P2_1"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "1/8",
					"x_prime": "1/8",
					"global_time": "1/8"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/8",
				"action": "(silent)",
				"transitions": [
					{
					"transition": {
						"PTA": "P1",
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
					"lock": "lock0", 
					"P1": "P1_1", 
					"P2": "P2_1"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "1/4",
					"x_prime": "1/4",
					"global_time": "1/4"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/4",
				"action": "is_0",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P1",
						"guard": "True",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"lock": "lock0", 
					"P1": "P1_2", 
					"P2": "P2_1"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "0",
					"x_prime": "1/2",
					"global_time": "1/2"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/4",
				"action": "is_0_prime",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P2",
						"guard": "True",
						"updates": {
							"x_prime": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"lock": "lock0", 
					"P1": "P1_2", 
					"P2": "P2_2"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "1/4",
					"x_prime": "0",
					"global_time": "3/4"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "9/4",
				"action": "set_2_prime",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P2",
						"guard": " x_prime > 2 AND 3 > x_prime",
						"updates": {
							"x_prime": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"lock": "lock2", 
					"P1": "P1_2", 
					"P2": "P2_3"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "5/2",
					"x_prime": "0",
					"global_time": "3"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "set_1",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P1",
						"guard": " x > 2 AND 3 > x",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"lock": "lock1", 
					"P1": "P1_3", 
					"P2": "P2_3"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "0",
					"x_prime": "0",
					"global_time": "3"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "3/2",
				"action": "is_1_prime",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P2",
						"guard": " 5 > x_prime AND x_prime > a",
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
					"lock": "lock1", 
					"P1": "P1_3", 
					"P2": "P2_4"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "3/2",
					"x_prime": "3/2",
					"global_time": "9/2"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1/2",
				"action": "is_1",
				"transitions": [
					{
					"transition": {
						"PTA": "lock",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "P1",
						"guard": " 5 > x AND x > a",
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
					"lock": "lock1", 
					"P1": "P1_4", 
					"P2": "P2_4"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"a": "1",
					"x": "2",
					"x_prime": "2",
					"global_time": "5"
				},
				"flows": {
					"x": "1", 
					"x_prime": "1", 
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
Number of states                        : 90
Number of transitions                   : 152
Number of computed states               : 153
Total computation time                  : 0.150 second
States/second in state space            : 599.4 (90/0.150 second)
Computed states/second                  : 1019.0 (153/0.150 second)
Estimated memory                        : 8.832 MiB (i.e., 1157710 words of size 8)
------------------------------------------------------------

------------------------------------------------------------
 Statistics: Algorithm counters
------------------------------------------------------------
main algorithm + parsing                : 0.155 second
main algorithm                          : 0.150 second
------------------------------------------------------------
 Statistics: Parsing counters
------------------------------------------------------------
model parsing and converting            : 0.004 second
------------------------------------------------------------
 Statistics: State computation counters
------------------------------------------------------------
number of constraints comparisons       : 189
number of state comparisons             : 189
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
total                                   : 0.163 second
------------------------------------------------------------
(************************************************************
 * Result by: IMITATOR 3.4-beta "Cheese Durian" (build ?????/?????)
 * Model    : '/imitator/fff/testConv.imi'
 * Generated: Tue Dec 13, 2022 14:17:02
 * Command  : /imitator/bin/imitator /imitator/fff/testConv.imi /imitator/fff/testConvProp3.imiprop -comparison equality -merge none
 ************************************************************)


------------------------------------------------------------
Number of IPTAs                         : 2
Number of clocks                        : 2
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
Total number of transitions             : 5
Average transitions per IPTA            : 2.5
------------------------------------------------------------

BEGIN RESULT

(************************************************************)
 Run #1

 Valuation:
  p = 1

 Other valuations with equivalent (discrete) run:
 5 >= p
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
					"specification": "l1", 
					"specification2": "sl1"
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
				"duration": "0",
				"action": "a1",
				"transitions": [
					{
					"transition": {
						"PTA": "specification2",
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
					"specification": "l1", 
					"specification2": "sl2"
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
				"duration": "0",
				"action": "s1",
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
					"specification": "l2", 
					"specification2": "sl2"
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
				"duration": "0",
				"action": "a2",
				"transitions": [
					{
					"transition": {
						"PTA": "specification2",
						"guard": " p >= x",
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
					"specification": "l2", 
					"specification2": "slT"
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
				"action": "s1",
				"transitions": [
					{
					"transition": {
						"PTA": "specification",
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
					"specification": "lT", 
					"specification2": "slT"
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
			}
		]
	}
}
(************************************************************)


(************************************************************)
 Run #2

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
					"specification": "l1", 
					"specification2": "sl1"
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
				"duration": "0",
				"action": "a1",
				"transitions": [
					{
					"transition": {
						"PTA": "specification2",
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
					"specification": "l1", 
					"specification2": "sl2"
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
				"duration": "0",
				"action": "s1",
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
					"specification": "l2", 
					"specification2": "sl2"
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
				"duration": "0",
				"action": "a2",
				"transitions": [
					{
					"transition": {
						"PTA": "specification2",
						"guard": " p >= x",
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
					"specification": "l2", 
					"specification2": "slT"
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
				"duration": "2",
				"action": "s2",
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
					"specification": "lT", 
					"specification2": "slT"
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
 Run #3

 Valuation:
  p = 1

 Other valuations with equivalent (discrete) run:
 5 >= p
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
					"specification": "l1", 
					"specification2": "sl1"
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
				"duration": "0",
				"action": "a1",
				"transitions": [
					{
					"transition": {
						"PTA": "specification2",
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
					"specification": "l1", 
					"specification2": "sl2"
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
				"duration": "0",
				"action": "a2",
				"transitions": [
					{
					"transition": {
						"PTA": "specification2",
						"guard": " p >= x",
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
					"specification": "l1", 
					"specification2": "slT"
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
				"duration": "1/2",
				"action": "s1",
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
					"specification": "l2", 
					"specification2": "slT"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "1/2",
					"global_time": "1/2"
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
				"duration": "1/2",
				"action": "s1",
				"transitions": [
					{
					"transition": {
						"PTA": "specification",
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
					"specification": "lT", 
					"specification2": "slT"
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
			}
		]
	}
}
(************************************************************)


(************************************************************)
 Run #4

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
					"specification": "l1", 
					"specification2": "sl1"
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
				"duration": "0",
				"action": "a1",
				"transitions": [
					{
					"transition": {
						"PTA": "specification2",
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
					"specification": "l1", 
					"specification2": "sl2"
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
				"duration": "0",
				"action": "a2",
				"transitions": [
					{
					"transition": {
						"PTA": "specification2",
						"guard": " p >= x",
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
					"specification": "l1", 
					"specification2": "slT"
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
				"action": "s1",
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
					"specification": "l2", 
					"specification2": "slT"
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
				"action": "s2",
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
					"specification": "lT", 
					"specification2": "slT"
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
 Run #5

 Valuation:
  p = 1

 Other valuations with equivalent (discrete) run:
 5 >= p
& p >= 0

 Run nature: impossible run

 Run:
{
	"run": {
		"nature": "negative",
		"valuation": {
			"p": "1"
			},
		"steps": [
			{
			"state": {
				"location": {
					"specification": "l1", 
					"specification2": "sl1"
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
				"duration": "1/2",
				"action": "a1",
				"transitions": [
					{
					"transition": {
						"PTA": "specification2",
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
					"specification": "l1", 
					"specification2": "sl2"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "1/2",
					"global_time": "1/2"
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
				"duration": "1/2",
				"action": "s1",
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
					"specification": "l2", 
					"specification2": "sl2"
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
			}
			{
			"transition": {
				"nature": "impossible",
				"duration": "3/2",
				"action": "a2"
			}
			},
			{
			"state": {
				"location": {
					"specification": "l2", 
					"specification2": "slT"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "5/2",
					"global_time": "5/2"
				},
				"flows": {
					"x": "1", 
					"global_time": "1"
				}
			}
			}
			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "s1"
			}
			},
			{
			"state": {
				"location": {
					"specification": "lT", 
					"specification2": "slT"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "7/2",
					"global_time": "7/2"
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
 Run #6

 Valuation:
  p = 4

 Other valuations with equivalent (discrete) run:
 p >= 4
& 5 >= p

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
					"specification": "l1", 
					"specification2": "sl1"
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
				"duration": "0",
				"action": "a1",
				"transitions": [
					{
					"transition": {
						"PTA": "specification2",
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
					"specification": "l1", 
					"specification2": "sl2"
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
				"duration": "0",
				"action": "s1",
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
					"specification": "l2", 
					"specification2": "sl2"
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
				"duration": "0",
				"action": "a2",
				"transitions": [
					{
					"transition": {
						"PTA": "specification2",
						"guard": " p >= x",
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
					"specification": "l2", 
					"specification2": "slT"
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
			}
			{
			"transition": {
				"nature": "impossible",
				"duration": "1",
				"action": "s2"
			}
			},
			{
			"state": {
				"location": {
					"specification": "lT", 
					"specification2": "slT"
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
		]
	}
}
(************************************************************)


(************************************************************)
 Run #7

 Valuation:
  p = 1

 Other valuations with equivalent (discrete) run:
 4 > p
& p >= 0

 Run nature: impossible run

 Run:
{
	"run": {
		"nature": "negative",
		"valuation": {
			"p": "1"
			},
		"steps": [
			{
			"state": {
				"location": {
					"specification": "l1", 
					"specification2": "sl1"
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
				"duration": "1/2",
				"action": "a1",
				"transitions": [
					{
					"transition": {
						"PTA": "specification2",
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
					"specification": "l1", 
					"specification2": "sl2"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "1/2",
					"global_time": "1/2"
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
				"duration": "1/2",
				"action": "s1",
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
					"specification": "l2", 
					"specification2": "sl2"
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
			}
			{
			"transition": {
				"nature": "impossible",
				"duration": "3/2",
				"action": "a2"
			}
			},
			{
			"state": {
				"location": {
					"specification": "l2", 
					"specification2": "slT"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "5/2",
					"global_time": "5/2"
				},
				"flows": {
					"x": "1", 
					"global_time": "1"
				}
			}
			}
			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "s2"
			}
			},
			{
			"state": {
				"location": {
					"specification": "lT", 
					"specification2": "slT"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "7/2",
					"global_time": "7/2"
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
 Run #8

 Valuation:
  p = 1

 Other valuations with equivalent (discrete) run:
 5 >= p
& p >= 0

 Run nature: impossible run

 Run:
{
	"run": {
		"nature": "negative",
		"valuation": {
			"p": "1"
			},
		"steps": [
			{
			"state": {
				"location": {
					"specification": "l1", 
					"specification2": "sl1"
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
				"duration": "3/2",
				"action": "a1",
				"transitions": [
					{
					"transition": {
						"PTA": "specification2",
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
					"specification": "l1", 
					"specification2": "sl2"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "3/2",
					"global_time": "3/2"
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
				"duration": "0",
				"action": "a2"
			}
			},
			{
			"state": {
				"location": {
					"specification": "l1", 
					"specification2": "slT"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "3/2",
					"global_time": "3/2"
				},
				"flows": {
					"x": "1", 
					"global_time": "1"
				}
			}
			}
			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "s1"
			}
			},
			{
			"state": {
				"location": {
					"specification": "l2", 
					"specification2": "slT"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "5/2",
					"global_time": "5/2"
				},
				"flows": {
					"x": "1", 
					"global_time": "1"
				}
			}
			}

			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "s1"
			}
			},
			{
			"state": {
				"location": {
					"specification": "lT", 
					"specification2": "slT"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "7/2",
					"global_time": "7/2"
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
 Run #9

 Valuation:
  p = 4

 Other valuations with equivalent (discrete) run:
 p >= 4
& 5 >= p

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
					"specification": "l1", 
					"specification2": "sl1"
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
				"duration": "0",
				"action": "a1",
				"transitions": [
					{
					"transition": {
						"PTA": "specification2",
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
					"specification": "l1", 
					"specification2": "sl2"
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
				"duration": "0",
				"action": "a2",
				"transitions": [
					{
					"transition": {
						"PTA": "specification2",
						"guard": " p >= x",
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
					"specification": "l1", 
					"specification2": "slT"
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
				"action": "s1",
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
					"specification": "l2", 
					"specification2": "slT"
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
				"action": "s2"
			}
			},
			{
			"state": {
				"location": {
					"specification": "lT", 
					"specification2": "slT"
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


(************************************************************)
 Run #10

 Valuation:
  p = 1

 Other valuations with equivalent (discrete) run:
 4 > p
& p >= 0

 Run nature: impossible run

 Run:
{
	"run": {
		"nature": "negative",
		"valuation": {
			"p": "1"
			},
		"steps": [
			{
			"state": {
				"location": {
					"specification": "l1", 
					"specification2": "sl1"
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
				"duration": "3/2",
				"action": "a1",
				"transitions": [
					{
					"transition": {
						"PTA": "specification2",
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
					"specification": "l1", 
					"specification2": "sl2"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "3/2",
					"global_time": "3/2"
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
				"duration": "0",
				"action": "a2"
			}
			},
			{
			"state": {
				"location": {
					"specification": "l1", 
					"specification2": "slT"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "3/2",
					"global_time": "3/2"
				},
				"flows": {
					"x": "1", 
					"global_time": "1"
				}
			}
			}
			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "s1"
			}
			},
			{
			"state": {
				"location": {
					"specification": "l2", 
					"specification2": "slT"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "5/2",
					"global_time": "5/2"
				},
				"flows": {
					"x": "1", 
					"global_time": "1"
				}
			}
			}

			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "s2"
			}
			},
			{
			"state": {
				"location": {
					"specification": "lT", 
					"specification2": "slT"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"p": "1",
					"x": "7/2",
					"global_time": "7/2"
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
Number of states                        : 16
Number of transitions                   : 18
Number of computed states               : 19
Total computation time                  : 0.031 second
States/second in state space            : 503.9 (16/0.031 second)
Computed states/second                  : 598.3 (19/0.031 second)
Estimated memory                        : 6.262 MiB (i.e., 820867 words of size 8)
------------------------------------------------------------

------------------------------------------------------------
 Statistics: Algorithm counters
------------------------------------------------------------
main algorithm + parsing                : 0.034 second
main algorithm                          : 0.031 second
------------------------------------------------------------
 Statistics: Parsing counters
------------------------------------------------------------
model parsing and converting            : 0.001 second
------------------------------------------------------------
 Statistics: State computation counters
------------------------------------------------------------
number of constraints comparisons       : 17
number of state comparisons             : 17
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
total                                   : 0.045 second
------------------------------------------------------------